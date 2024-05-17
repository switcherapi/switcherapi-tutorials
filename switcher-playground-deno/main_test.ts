import { assertEquals } from 'jsr:@std/assert';
import { checkSwitcher, setupSdk } from './main.ts';
import { Client } from 'jsr:@switcherapi/switcher-client-deno@2.0.1';

Deno.test({
  name: 'it should check switcher',
  async fn() {
    // given
    await setupSdk();

    // test
    const switcher = await checkSwitcher();
    assertEquals(switcher.result, true);

    // teardown snapshot watcher
    Client.unloadSnapshot();
  },
});

Deno.test({
  name: 'it should check switcher as false when by-passed',
  async fn() {
    // given
    await setupSdk();
    Client.assume('MY_SWITCHER').false();

    // test
    const switcher = await checkSwitcher();
    assertEquals(switcher.result, false);

    // teardown snapshot watcher
    Client.unloadSnapshot();
    Client.forget('MY_SWITCHER');
  },
});
