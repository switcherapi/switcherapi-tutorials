async function loadModule() {
    return import('switcher-client').then((module) => {
        return module;
    });
}

module.exports = loadModule;
