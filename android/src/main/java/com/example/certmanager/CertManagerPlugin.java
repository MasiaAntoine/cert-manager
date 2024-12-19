package com.example.certmanager;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.security.KeyChain;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class CertManagerPlugin {

    // Exemple de méthode pour installer un certificat p12 dans le KeyChain
    public boolean installCert(Context context, String certBase64) {
        try {
            // Décoder le certificat en Base64
            byte[] decodedCert = Base64.decode(certBase64, Base64.DEFAULT);
            InputStream certStream = new ByteArrayInputStream(decodedCert);

            // Charger le certificat
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            Certificate certificate = certFactory.generateCertificate(certStream);

            // Créer une intention pour installer le certificat
            Intent installIntent = KeyChain.createInstallIntent();
            installIntent.putExtra(KeyChain.EXTRA_CERTIFICATE, decodedCert);
            installIntent.putExtra(KeyChain.EXTRA_NAME, "My Certificate");

            // Démarrer l'activité d'installation
            context.startActivity(installIntent);

            Log.i("CertManagerPlugin", "Certificate installation intent started successfully!");
            return true;
        } catch (Exception e) {
            Log.e("CertManagerPlugin", "Error installing certificate", e);
            return false;
        }
    }
}