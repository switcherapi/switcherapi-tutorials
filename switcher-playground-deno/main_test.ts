import { checkSwitcher, setupSdk } from './main.ts';
import { assertEquals, Client, dirname, fromFileUrl } from './deps.ts';

const testBody = (fn: (t: Deno.TestContext) => void | Promise<void>) => {
  return async (t: Deno.TestContext) => {
    await fn(t);

    // Teardown: unload snapshot
    Client.unloadSnapshot();
  };
};

Deno.test({
  name: 'it should check switcher using snapshot',
  fn: testBody(async (t) => {
    await t.step('should setup SDK', () => {
      const scriptDir = dirname(fromFileUrl(new URL(import.meta.url)));
      const snapshotLocation = `${scriptDir}/snapshot`;

      Client.buildContext({
        url: 'https://api.switcherapi.com',
        apiKey: Deno.env.get('SWITCHER_API_KEY'),
        domain: 'Switcher API',
        component: 'switcher4deno',
      }, {
        local: true,
        snapshotLocation,
      });
    });

    await t.step('should load snapshot', async () => {
      await Client.loadSnapshot();
      assertEquals(Client.snapshotVersion, 1);
    });

    await t.step('should check switcher', () => {
      const switcher = checkSwitcher('CLIENT_DENO_FEATURE');
      assertEquals(switcher.result, true);
    });
  }),
});

Deno.test({
  name: 'it should check switcher as false when by-passed',
  fn: testBody(async () => {
    // given
    await setupSdk();
    Client.assume('CLIENT_DENO_FEATURE').false();

    // test
    const switcher = checkSwitcher('CLIENT_DENO_FEATURE');
    assertEquals(switcher.result, false);
    Client.forget('CLIENT_DENO_FEATURE');
  }),
});
