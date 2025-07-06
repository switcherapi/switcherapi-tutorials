/**
 * Switcher Playground - Local Snapshot Example
 * This example demonstrates how to use the Switcher Client SDK with a local snapshot.
 */

import { Client } from 'switcher-client';

async function setupSdk() {
    Client.buildContext({
        domain: 'Switcher API'
    }, {
        local: true,
        snapshotLocation: './snapshot'
    });

    await Client.loadSnapshot().then(() => {
        console.log('Snapshot loaded!');
        Client.subscribeNotifyError((error) => console.error('NotifyError:', error));
        Client.watchSnapshot({ success: () => console.log('Snapshot updated:', Client.snapshotVersion) });
    });
}

async function run() {
    await setupSdk();
    const switcher = Client.getSwitcher();

    setInterval(() => {
        const time = Date.now();
        const result = switcher
            .detail()
            .isItOn('MY_SWITCHER');
            
        console.log(`- ${Date.now() - time} ms - ${JSON.stringify(result)}`);
    }, 1000);
}

run();