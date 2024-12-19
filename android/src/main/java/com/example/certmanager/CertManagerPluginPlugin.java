package com.example.certmanager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CertManagerPlugin")
public class CertManagerPluginPlugin extends Plugin {

    private CertManagerPlugin implementation = new CertManagerPlugin();

    // Méthode qui appelle le plugin pour installer le certificat
    @PluginMethod
    public void installCertificate(PluginCall call) {
        String certBase64 = call.getString("certBase64");  // Recevoir le certificat en Base64

        if (certBase64 == null) {
            call.reject("Certificate is required.");
            return;
        }

        boolean success = implementation.installCert(getContext(), certBase64);  // Appel de la méthode pour installer le certificat

        if (success) {
            JSObject ret = new JSObject();
            ret.put("message", "Certificate installed successfully.");
            call.resolve(ret);  // Réponse si le certificat est installé avec succès
        } else {
            call.reject("Failed to install certificate.");
        }
    }
}
