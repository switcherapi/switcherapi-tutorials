***

<div align="center">
<b>Switcher Tuorials</b><br>
A collection of tutorials and code snippets to help you understand how to use Switcher Client SDKs.
</div>

***

## switcher-playground-java

This project shows how to use the Switcher Java SDK to integrate feature flags into your Java application.<br>
Find how to configure the SDK using the 2 ways available:
- Using `switcherapi.properties` file
- Using ContextBuilder

It also includes examples of how to use:
- Snapshot Watcher for hot-reloading feature flags
- Throttling to control the rate of requests to the Switcher API
- Implement automated tests using SwitcherTest annotation

## switcher-spring-playground

This project shows how to use the Switcher Java SDK with Spring Boot applications.<br>
Find how to set up the SDK using Spring Boot environment configuration properties.

It includes examples of how to use:
- Snapshot Watcher for hot-reloading feature flags
- Throttling to control the rate of requests to the remote API
- Implement automated tests using SwitcherTest annotation

## switcher-playground-js/bun

These projects show how to use the Switcher JS SDK to integrate feature flags into your application.<br>
Learn how to set up the JS SDK withing a CommonJS, ES6 module type project or native TypeScript runtime (bun)

It includes examples of how to use:
- Local: standalone modde that uses a snapshot file
- Hybrid: a hybrid mode that uses the Switcher API and a snapshot loaded from the API
- Remote: a remote mode that uses the Switcher API only

## switcher-playground-deno

This project shows how to use the Switcher Client SDK with Deno.

It includes examples of how to use:
- Local: standalone mode that uses a snapshot file
- Test samples: how to use the Client stub feature to manage feature flags during test execution