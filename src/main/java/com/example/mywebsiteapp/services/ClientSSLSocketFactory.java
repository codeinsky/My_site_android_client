//package com.example.mywebsiteapp.services;
//import com.example.mywebsiteapp.R;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import java.security.KeyManagementException;
//import java.security.KeyStore;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.Certificate;
//import java.security.cert.CertificateException;
//import java.security.cert.CertificateFactory;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.TrustManagerFactory;
//
//
//public class ClientSSLSocketFactory  {
//    private SSLSocketFactory getSSLSocketFactory()
//            throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException, KeyManagementException {
//        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//        InputStream caInput = getResources().openRawResource(R.raw.keystore); // this cert file stored in \app\src\main\res\raw folder path
//        Certificate ca = cf.generateCertificate(caInput);
//        caInput.close();
//        KeyStore keyStore = KeyStore.getInstance("BKS");
//        keyStore.load(null, null);
//        keyStore.setCertificateEntry("ca", ca);
//        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
//        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
//        tmf.init(keyStore);
//        TrustManager[] wrappedTrustManagers = getWrappedTrustManagers(tmf.getTrustManagers());
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(null, wrappedTrustManagers, null);
//
//        return sslContext.getSocketFactory();
//    }
//
//
//    }


