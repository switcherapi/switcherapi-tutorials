import { Client, load } from './deps.ts';

await load({ export: true, envPath: '.env' });

export async function setupSdk() {
  Client.buildContext({
    url: 'https://api.switcherapi.com',
    apiKey: Deno.env.get('SWITCHER_API_KEY'),
    domain: 'Switcher API',
    component: 'switcher4deno',
  });
}

export async function checkSwitcher(key: string, value = '') {
  const switcher = Client.getSwitcher()
    .checkValue(value);

  return switcher.isItOnDetail(key);
}

export async function run() {
  await setupSdk();

  setInterval(async () => {
    const time = Date.now();
    const result = await checkSwitcher('CLIENT_DENO_FEATURE', 'user_1');
    console.log(`- ${Date.now() - time} ms - ${JSON.stringify(result)}`);
  }, 1000);
}

if (import.meta.main) {
  run();
}
