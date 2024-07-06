import { Client, dirname, fromFileUrl, type ResultDetail, type SwitcherContext, type SwitcherOptions } from './deps.ts';

export async function setupSdk() {
  const context: SwitcherContext = {
    url: 'https://api.switcherapi.com',
    apiKey: 'JDJiJDA4JEFweTZjSTR2bE9pUjNJOUYvRy9raC4vRS80Q2tzUnk1d3o1aXFmS2o5eWJmVW11cjR0ODNT',
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
