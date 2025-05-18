import { 
    Client, 
    type SwitcherContext, 
    type SwitcherOptions, 
    type ResultDetail 
} from 'switcher-client';

async function setupSdk() {
    const context: SwitcherContext = {
        url: 'https://api.switcherapi.com',
        apiKey: '[API_KEY]',
        domain: 'Switcher API',
        component: 'switcher-client-js',
    };

    const options: SwitcherOptions = {
        regexSafe: false, // false required (Bun cannot handle child process) 
        local: true,
        snapshotLocation: './snapshot',
    };

    Client.buildContext(context, options);
    Client.watchSnapshot({
        success: () => console.log('Snapshot updated!'),
        reject: (error) => console.error('Snapshot update failed!', error),
    });

    await Client.loadSnapshot().then(() => console.log('Snapshot loaded!'));
}

async function logCall(isItOn: () => Promise<boolean | ResultDetail>) {
    const time = Date.now();
    const result = await isItOn();
    console.log(`- ${Date.now() - time} ms - ${JSON.stringify(result)}`);
}

async function run() {
    await setupSdk();

    const switcher = Client.getSwitcher()
        .detail()
        .defaultResult(false);

    setInterval(() => logCall(async () => switcher.isItOn('CLIENT_JS_FEATURE')), 1000);
}

run();