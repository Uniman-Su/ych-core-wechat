package com.ych.core.wechat.pay;

import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import org.apache.commons.io.IOUtils;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.ych.core.model.SystemParameterHolder;

public class HttpClientFactoryBean implements FactoryBean<CloseableHttpClient> {

    private Resource keyStoreResource;

    private SystemParameterHolder wxPayMerchantId;

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.FactoryBean#getObject()
     */
    @Override
    public CloseableHttpClient getObject() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");

        InputStream is = keyStoreResource.getInputStream();

        try {
            keyStore.load(is, wxPayMerchantId.getStringValue().toCharArray());
        } catch (IOException e) {
            IOUtils.closeQuietly(is);
            throw e;
        }

        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, wxPayMerchantId.getStringValue().toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.FactoryBean#getObjectType()
     */
    @Override
    public Class<CloseableHttpClient> getObjectType() {
        return CloseableHttpClient.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.FactoryBean#isSingleton()
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * @param keyStoreResource
     *         签名秘钥的资源
     */
    public void setKeyStoreResource(Resource keyStoreResource) {
        this.keyStoreResource = keyStoreResource;
    }

    /**
     * @param wxPayMerchantId
     *         微信支付商户ID
     */
    public void setWxPayMerchantId(SystemParameterHolder wxPayMerchantId) {
        this.wxPayMerchantId = wxPayMerchantId;
    }
}
