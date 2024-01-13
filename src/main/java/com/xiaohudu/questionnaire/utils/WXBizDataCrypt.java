package com.xiaohudu.questionnaire.utils;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Base64;

@Slf4j
public class WXBizDataCrypt {
  
  /**
   * 微信信息解密
   *
   * @param data // 密文
   * @param key // 秘钥
   * @param iv // 偏移量
   * @return
   * @throws Exception
   */
  public static String decryptData(String data, String key, String iv) {
    try {
      byte[] byteData = Base64.getDecoder().decode(data);
      byte[] byteKey = Base64.getDecoder().decode(key);
      byte[] byteIv = Base64.getDecoder().decode(iv);

      Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      Key sKeySpec = new SecretKeySpec(byteKey, "AES");
      AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
      params.init(new IvParameterSpec(byteIv));
      cipher.init(Cipher.DECRYPT_MODE, sKeySpec, params);

      byte[] byteResult = cipher.doFinal(byteData);

      return new String(byteResult);
    } catch (Exception e) {
      throw new RuntimeException("wx data decrypt fail", e);
    }
  }
}
