import {
  Client,
  dirname,
  fromFileUrl,
  load,
  type ResultDetail,
  type SwitcherContext,
  type SwitcherOptions
} from './deps.ts';

await load({ export: true, envPath: '.env' });

export async function setupSdk() {
  const context: SwitcherContext = {
    url: 'https://api.switcherapi.com',
    apiKey: Deno.env.get('SWITCHER_API_KEY') || '',
    domain: 'Playground',
    component: 'switcher-playground',
  };

  const scriptDir = dirname(fromFileUrl(new URL(import.meta.url)));
  const snapshotLocation = `${scriptDir}/snapshot`;

  const options: SwitcherOptions = {
    local: true,
    snapshotLocation,
  };

  Client.buildContext(context, options);
  await Client.loadSnapshot({ watchSnapshot: true }).then(() => console.log('Snapshot loaded!'));
}

export function checkSwitcher() {
  const switcher = Client.getSwitcher('MY_SWITCHER')
    .checkValue('user_1')
    .detail()
    .throttle(1000)
    .defaultResult(true);

  return switcher.isItOn() as Promise<ResultDetail>;
}

export function run() {
  setInterval(async () => {
    const time = Date.now();
    const result = await checkSwitcher();
    console.clear();
    console.log(`- ${Date.now() - time} ms - ${JSON.stringify(result)}`);
  }, 1000);
}

if (import.meta.main) {
  await setupSdk();
  run();
}
