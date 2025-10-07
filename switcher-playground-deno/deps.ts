// test dependencies
export { assertEquals } from 'jsr:@std/assert';

// runtime dependencies
export { dirname, fromFileUrl } from 'jsr:@std/path@1.1.2';
export { load } from 'jsr:@std/dotenv@0.225.5';
export {
  Client,
  type SwitcherContext,
  type SwitcherOptions,
  SwitcherResult,
} from 'jsr:@switcherapi/switcher-client-deno@2.4.0';
