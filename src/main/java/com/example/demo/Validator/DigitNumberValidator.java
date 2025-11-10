package com.example.demo.Validator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class DigitNumberValidator implements ConstraintValidator<DigitNumber, Integer>{

    @Override
    public void initialize(DigitNumber digitnumber) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        
        // 負の数はエラー
        if (value < 0) {
            return false;
        }
        
        // リクエストから元の文字列を取得
        String originalValue = getOriginalValueFromRequest("employeeNo");
        
        if (originalValue != null && !originalValue.trim().isEmpty()) {
            String trimmedValue = originalValue.trim();
            
            // 全角数字を半角数字に変換
            String normalizedValue = convertFullWidthToHalfWidth(trimmedValue);
            
            // 数値部分のみを抽出
            String digitsOnly = normalizedValue.replaceAll("[^0-9]", "");
            
            // 桁数チェック（1桁以上10桁以内）
            int length = digitsOnly.length();
            if (length < 1 || length > 10) {
                return false;
            }
        } else {
            // リクエストパラメータが取得できない場合は、Integer値で判定
            int length = String.valueOf(value).length();
            if (length < 1 || length > 10) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * HTTPリクエストから元の文字列を取得
     */
    private String getOriginalValueFromRequest(String paramName) {
        try {
            ServletRequestAttributes attributes = 
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                return request.getParameter(paramName);
            }
        } catch (Exception e) {
            // リクエストコンテキストが利用できない場合は無視
        }
        return null;
    }
    
    /**
     * 全角数字を半角数字に変換
     */
    private String convertFullWidthToHalfWidth(String input) {
        if (input == null) return null;
        
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= '０' && c <= '９') {
                sb.append((char) (c - '０' + '0'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}