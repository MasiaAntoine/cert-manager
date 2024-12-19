import { WebPlugin } from '@capacitor/core';

import type { CertManagerPluginPlugin } from './definitions';

export class CertManagerPluginWeb extends WebPlugin implements CertManagerPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
