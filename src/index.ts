import { registerPlugin } from '@capacitor/core';

import type { CertManagerPluginPlugin } from './definitions';

const CertManagerPlugin = registerPlugin<CertManagerPluginPlugin>('CertManagerPlugin', {
  web: () => import('./web').then((m) => new m.CertManagerPluginWeb()),
});

export * from './definitions';
export { CertManagerPlugin };
