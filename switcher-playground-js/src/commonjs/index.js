const loadModule = require('./switcher-client-async.js');

async function setupSdk() {
    const { Switcher } = await loadModule();

    const context = {
        url: 'https://api.switcherapi.com',
        apiKey: 'JDJiJDA4JEFweTZjSTR2bE9pUjNJOUYvRy9raC4vRS80Q2tzUnk1d3o1aXFmS2o5eWJmVW11cjR0ODNT',
        domain: 'Playground',
        component: 'switcher-playground',
    };
    
    const options = {
        logger: true,
        offline: true,
        snapshotLocation: './snapshot',
    };

    Switcher.buildContext(context, options);
    Switcher.loadSnapshot().then(() => console.log('Snapshot loaded!'));
}

async function run() {
    const { Switcher, checkValue } = await loadModule();
    
    const switcher = Switcher.factory();
    await switcher.isItOn('MY_SWITCHER', [checkValue('user_2')]);
    console.log(JSON.stringify(Switcher.getLogger('MY_SWITCHER'), null, 4));
}

setupSdk();
run();