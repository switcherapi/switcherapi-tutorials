const loadModule = require('./switcher-client-async.js');

async function setupSdk() {
    const { Client } = await loadModule();

    Client.buildContext({
        url: 'https://api.switcherapi.com',
        apiKey: '[API_KEY]',
        domain: 'Playground',
        component: 'switcher-playground'
    }, {
        logger: true,
        local: true,
        snapshotLocation: './snapshot'
    });

    Client.loadSnapshot().then(() => console.log('Snapshot loaded!'));
    Client.subscribeNotifyError((error) => console.error('NotifyError:', error));
    Client.watchSnapshot({
        success: (snapshot) => console.log('Snapshot updated:', snapshot),
    });
}

async function logCall(isItOn) {
    const time = Date.now();
    const result = await isItOn();
    console.log(`- ${Date.now() - time} ms - ${JSON.stringify(result)}`);
}

async function run() {
    const { Client } = await loadModule();
    const switcher = Client.getSwitcher().detail();
    
    setInterval(() => logCall(async () => switcher.isItOn('MY_SWITCHER')), 1000);
}

setupSdk();
run();