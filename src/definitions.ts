export interface CertManagerPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
