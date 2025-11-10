package com.example.demo.Validator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HalfNumberValidator implements ConstraintValidator<HalfNumber, Integer> {

    @Override
    public void initialize(HalfNumber halfnumber) {
    }
    
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        // リクエストから元の文字列を取得
        String originalValue = getOriginalValueFromRequest("employeeNo");
        
        if (originalValue != null && !originalValue.trim().isEmpty()) {
            String trimmedValue = originalValue.trim();
            
            // 全角数字が含まれているかチェック
            if (containsFullWidthNumber(trimmedValue)) {
                return false;
            }
            
            // 半角数字以外の文字が含まれているかチェック
            if (!trimmedValue.matches("^\\d+$")) {
                return false;
            }
        }
        
        // 負の数はエラー
        if (value < 0) {
            return false;
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
     * 全角数字が含まれているかチェック
     */
    private boolean containsFullWidthNumber(String input) {
        if (input == null) return false;
        
        for (char c : input.toCharArray()) {
            if (c >= '０' && c <= '９') {
                return true;
            }
        }
        return false;
    }
}