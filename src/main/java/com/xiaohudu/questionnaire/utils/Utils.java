package com.xiaohudu.questionnaire.utils;

import com.xiaohudu.questionnaire.entity.BaseTreeEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

public class Utils {

  public static String randomUUID() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  public static String base64Decode(String value) throws UnsupportedEncodingException {
    if (StringUtils.isNotBlank(value)) {
      return new String(Base64.getDecoder().decode(value), "UTF-8");
    } else {
      return "";
    }
  }

  public static String base64Encode(String value) throws UnsupportedEncodingException {
    if (StringUtils.isNotBlank(value)) {
      return Base64.getEncoder().encodeToString(value.getBytes("UTF-8"));
    } else {
      return "";
    }
  }

  public static String decodeURIComponent(String value) throws UnsupportedEncodingException {
    if (StringUtils.isNotBlank(value)) {
      return URLDecoder.decode(value, "UTF-8");
    } else {
      return "";
    }
  }

  public static String encodeURIComponent(String value) throws UnsupportedEncodingException {
    if (StringUtils.isNotBlank(value)) {
      return URLEncoder.encode(value, "UTF-8")
              .replaceAll("\\+", "%20")
              .replaceAll("\\%21", "!")
              .replaceAll("\\%27", "'")
              .replaceAll("\\%28", "(")
              .replaceAll("\\%29", ")")
              .replaceAll("\\%7E", "~");
    } else {
      return "";
    }
  }

  /**
   * list转tree
   * @param list
   * @param parentId
   * @return
   * @param <T>
   */
  public static <T extends BaseTreeEntity> List<T> list2Tree(List<T> list, String parentId) {
    Map<String, List<T>> entityByParentIdMap = new HashMap<>();
    list.forEach(entity -> {
      List<T> children = entityByParentIdMap.getOrDefault(entity.getParentId(), new ArrayList<>());
      children.add(entity);
      entityByParentIdMap.put(entity.getParentId(), children);
    });
    list.forEach(entity -> entity.setChildren((List<BaseTreeEntity>) entityByParentIdMap.get(entity.getId())));
    return list.stream().filter(entity -> parentId == null ? null == entity.getParentId() : parentId.equals(entity.getParentId())).collect(Collectors.toList());
  }

  /**
   * 根据盐值和前端密码生成入库密码
   * @param password
   * @param salt
   * @return
   */
  public static String encodePassword(String password, String salt) {
    return DigestUtils.md5DigestAsHex((password + salt).getBytes()).toUpperCase();
  }

}
