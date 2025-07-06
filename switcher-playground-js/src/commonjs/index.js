const asyncModule = require('./switcher-client-async.js');

async function setupSdk() {
    const { Client } = await asyncModule();

    Client.buildContext({
        domain: 'Playground',
    }, {
        local: true,
        snapshotLocation: './snapshot'
    });

    Client.loadSnapshot().then(() => {
        console.log('Snapshot loaded!');
        Client.subscribeNotifyError((error) => console.error('NotifyError:', error));
        Client.watchSnapshot({ success: () => console.log('Snapshot updated:', Client.snapshotVersion) });
    });

    return Client;
}

async function run() {
    const Client = await setupSdk();
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