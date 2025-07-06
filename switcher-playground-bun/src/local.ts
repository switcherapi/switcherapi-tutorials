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
        snapshotLocation: './snapshot',
    });

    await Client.loadSnapshot().then(() => {
        console.log('Snapshot loaded!');
        Client.watchSnapshot({
            success: () => console.log('Snapshot updated!', Client.snapshotVersion),
            reject: (error) => console.error('Snapshot update failed!', error),
        });
    });
}

async function run() {
    await setupSdk();
    const switcher = Client.getSwitcher();

    setInterval(() => {
        const time = Date.now();
        const result = switcher.isItOnDetail('CLIENT_JS_FEATURE');

        console.log(`- ${Date.now() - time} ms - ${JSON.stringify(result)}`);
    }, 1000);
}

run();