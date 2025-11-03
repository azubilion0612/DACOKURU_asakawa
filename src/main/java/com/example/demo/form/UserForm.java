package com.example.demo.form;

import java.time.LocalDate;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.example.demo.Validator.DateFormat;
import com.example.demo.Validator.DigitNumber;
import com.example.demo.Validator.HalfNumber;

import lombok.Data;

@Data
public class UserForm implements ValidationGroups {

    private Long id;

    @NotBlank(message = "名前(正式表示)を入力してください。")
    @Pattern(regexp = "^[^ -~｡-ﾟ]+$", message = "名前(正式表示)は全角で入力してください。")
    @Size(min = 1, max = 255, message ="名前（正式表示）は1文字以上、255文字以内で入力してください。")
    private String fnJp;

    @NotBlank(message = "名前(ひらがな)を入力してください。")
    @Pattern(regexp = "^[\\u3040-\\u309F]+$", message = "名前(ひらがな）は全角ひらがなで入力してください。")
    @Size(min = 1, max = 255, message = "名前（ひらがな）は1文字以上、255文字以内で入力してください。")
    private String fnJpHira;

    @NotBlank(message = "名前(カタカナ)を入力してください。")
    @Pattern(regexp = "^[\\u30A0-\\u30FF]+$", message = "名前(カタカナ)は全角カタカナで入力してください。")
    @Size(min = 1, max = 255, message = "名前（カタカナ）は1文字以上、255文字以内で入力してください。")
    private String fnJpKata;

    @NotBlank(message = "名前(英語)を入力してください。")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "名前(英語)は半角英字で入力してください。")
    @Size(min = 1, max = 255, message = "名前（英語）は1文字以上、255文字以内で入力してください。")
    private String fnEn;

    @NotBlank(message = "姓(正式表示)を入力してください。")
    @Pattern(regexp = "^[^ -~｡-ﾟ]+$", message = "姓(正式表示)は全角で入力してください。")
    @Size(min = 1, max = 255, message = "姓(正式表示)は1文字以上、255文字以内で入力してください。")
    private String lnJp;

    @NotBlank(message = "姓(ひらがな)を入力してください。")
    @Pattern(regexp = "^[\\u3040-\\u309F]+$", message = "姓(ひらがな）は全角ひらがなで入力してください。")
    @Size(min = 1, max = 255, message = "姓(ひらがな)は1文字以上、255文字以内で入力してください。")
    private String lnJpHira;

    @NotBlank(message = "姓(カタカナ)を入力してください。")
    @Pattern(regexp = "^[\\u30A1-\\u30FC]+$", message = "姓(カタカナ)は全角カタカナで入力してください。")
    @Size(min = 1, max = 255, message = "姓(カタカナ)は1文字以上、255文字以内で入力してください。")
    private String lnJpKata;

    @NotBlank(message = "姓(英語)を入力してください。")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "姓(英語)は半角英字で入力してください。")
    @Size(min = 1, max = 255, message = "姓(英語)は1文字以上、255文字以内で入力してください。")
    private String lnEn;

    // 旧姓の入力が必要な場合にチェック
    @AssertTrue(message = "旧姓(正式表示)は1文字以上、255文字以内で入力してください。")
    public boolean isOldNameJpLengthValid() {
        if (olnJp != null && !olnJp.trim().isEmpty()) {
            return olnJp.length() >= 1 && olnJp.length() <= 255;
        }
        return true;
    }

    @AssertTrue(message = "旧姓(正式表示)は全角で入力してください。")
    public boolean isOldNameJpFormatValid() {
        if (olnJp != null && !olnJp.trim().isEmpty()) {
            String fullWidthOlnJpRegex = "^[\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+$";
            return olnJp.matches(fullWidthOlnJpRegex);
        }
        return true;
    }
    private String olnJp;

    @AssertTrue(message = "旧姓(ひらがな)は1文字以上、255文字以内で入力してください。")
    public boolean isOldNameJpHiraLengthValid() {
        if (olnJpHira != null && !olnJpHira.trim().isEmpty()) {
            return olnJpHira.length() >= 1 && olnJpHira.length() <= 255;
        }
        return true;
    }

    @AssertTrue(message = "旧姓(ひらがな)は全角ひらがなで入力してください。")
    public boolean isOldNameJpHiraFormatValid() {
        if (olnJpHira != null && !olnJpHira.trim().isEmpty()) {
            String fullWidthOlnJpHiraRegex = "^[\\u3040-\\u309F]+$";
            return olnJpHira.matches(fullWidthOlnJpHiraRegex);
        }
        return true;
    }
    private String olnJpHira;

    @AssertTrue(message = "旧姓(カタカナ)は1文字以上、255文字以内で入力してください。")
    public boolean isOldNameJpKataLengthValid() {
        if (olnJpKata != null && !olnJpKata.trim().isEmpty()) {
            return olnJpKata.length() >= 1 && olnJpKata.length() <= 255;
        }
        return true;
    }

    @AssertTrue(message = "旧姓(カタカナ)は全角カタカナで入力してください。")
    public boolean isOldNameJpKataFormatValid() {
        if (olnJpKata != null && !olnJpKata.trim().isEmpty()) {
            String fullWidthOlnJpKataRegex = "^[\\\\u30A0-\\\\u30FF]+$";
            return olnJpKata.matches(fullWidthOlnJpKataRegex);
        }
        return true;
    }
    private String olnJpKata;

    @AssertTrue(message = "旧姓(英語)は1文字以上、255文字以内で入力してください。")
    public boolean isOldNameEnLengthValid() {
        if (olnEn != null && !olnEn.trim().isEmpty()) {
            return olnEn.length() >= 1 && olnEn.length() <= 255;
        }
        return true;
    }

    @AssertTrue(message = "旧姓(英語)は半角で入力してください。")
    public boolean isOldNameEnFormatValid() {
        if (olnEn != null && !olnEn.trim().isEmpty()) {
            String fullWidthOlnEnRegex = "^[a-zA-Z]+$";
            return olnEn.matches(fullWidthOlnEnRegex);
        }
        return true;
    }
    private String olnEn;

    @AssertTrue(message = "ミドルネーム(正式表示)は1文字以上、255文字以内で入力してください。")
    public boolean isMiddleNameJpLengthValid() {
        if (mnJp != null && !mnJp.trim().isEmpty()) {
            return mnJp.length() >= 1 && mnJp.length() <= 255;
        }
        return true;
    }

    @AssertTrue(message = "ミドルネーム(正式表示)は全角で入力してください。")
    public boolean isMiddleNameJpFormatValid() {
        if (mnJp != null && !mnJp.trim().isEmpty()) {
            String fullWidthMnJpRegex = "^[\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF]+$";
            return mnJp.matches(fullWidthMnJpRegex);
        }
        return true;
    }
    private String mnJp;

    @AssertTrue(message = "ミドルネーム(ひらがな)は1文字以上、255文字以内で入力してください。")
    public boolean isMiddleNameJpHiraLengthValid() {
        if (mnJpHira != null && !mnJpHira.trim().isEmpty()) {
            return mnJpHira.length() >= 1 && mnJpHira.length() <= 255;
        }
        return true;
    }

    @AssertTrue(message = "ミドルネーム(ひらがな)は全角ひらがなで入力してください。")
    public boolean isMiddleNameJpHiraFormatValid() {
        if (mnJpHira != null && !mnJpHira.trim().isEmpty()) {
            String fullWidthMnJpHiraRegex = "^[\\u3040-\\u309F]+$";
            return mnJpHira.matches(fullWidthMnJpHiraRegex);
        }
        return true;
    }
    private String mnJpHira;

    @AssertTrue(message = "ミドルネーム(カタカナ)は1文字以上、255文字以内で入力してください。")
    public boolean isMiddleNameJpKataLengthValid() {
        if (mnJpKata != null && !mnJpKata.trim().isEmpty()) {
            return mnJpKata.length() >= 1 && mnJpKata.length() <= 255;
        }
        return true;
    }

    @AssertTrue(message = "ミドルネーム(カタカナ)は全角カタカナで入力してください。")
    public boolean isMiddleNameJpKataFormatValid() {
        if (mnJpKata != null && !mnJpKata.trim().isEmpty()) {
            String fullWidthMnJpKataRegex = "^[\\\\u30A0-\\\\u30FF]+$";
            return mnJpKata.matches(fullWidthMnJpKataRegex);
        }
        return true;
    }
    private String mnJpKata;

    @AssertTrue(message = "ミドルネーム(英語)は1文字以上、255文字以内で入力してください。")
    public boolean isMiddleNameEnLengthValid() {
        if (mnEn != null && !mnEn.trim().isEmpty()) {
            return mnEn.length() >= 1 && mnEn.length() <= 255;
        }
        return true;
    }

    @AssertTrue(message = "ミドルネーム(英語)は半角で入力してください。")
    public boolean isMiddleNameEnFormatValid() {
        if (mnEn != null && !mnEn.trim().isEmpty()) {
            String fullWidthMnEnRegex = "^[a-zA-Z]+$";
            return mnEn.matches(fullWidthMnEnRegex);
        }
        return true;
    }
    private String mnEn;

    @NotBlank(message = "メールアドレスを入力してください。")
    @Email(message = "メールアドレスの形式が正しくありません。")
    @Size(max = 255, message = "メールアドレスは255文字以内で入力してください。")
    private String email;

    @NotBlank(message = "パスワードを入力してください。")
    @Size(min = 8, max = 255, message = "パスワードは8文字以上255文字以内で入力してください。")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "パスワードは半角英数字で入力してください。")
    private String password;

    @NotNull(message = "社員番号を入力してください。")
    @HalfNumber
    @DigitNumber
    private Integer employeeNo;

    private Integer currentEmployeeNo;

    @NotNull(message = "入社日を入力してください。")
    @DateFormat
    private LocalDate joiningDate;

    private Boolean englishNotation;

 // 旧姓フィールドのいずれかが入力された場合は、それ以外の旧姓フィールドも必須
    @AssertTrue(message = "旧姓の各欄に一つでも入力があった場合は必須です。")
    public boolean isOldNameJpValid() {
        if ((olnJpHira != null && !olnJpHira.isEmpty()) ||
                (olnJpKata != null && !olnJpKata.isEmpty()) ||
                (olnEn != null && !olnEn.isEmpty())) {
            return olnJp != null && !olnJp.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = "旧姓の各欄に一つでも入力があった場合は必須です。")
    public boolean isOldNameJpHiraValid() {
        if ((olnJp != null && !olnJp.isEmpty()) ||
                (olnJpKata != null && !olnJpKata.isEmpty()) ||
                (olnEn != null && !olnEn.isEmpty())) {
            return olnJpHira != null && !olnJpHira.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = "旧姓の各欄に一つでも入力があった場合は必須です。")
    public boolean isOldNameJpKataValid() {
        if ((olnJp != null && !olnJp.isEmpty()) ||
                (olnJpHira != null && !olnJpHira.isEmpty()) ||
                (olnEn != null && !olnEn.isEmpty())) {
            return olnJpKata != null && !olnJpKata.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = "旧姓の各欄に一つでも入力があった場合は必須です。")
    public boolean isOldNameEnValid() {
        if ((olnJp != null && !olnJp.isEmpty()) ||
                (olnJpHira != null && !olnJpHira.isEmpty()) ||
                (olnJpKata != null && !olnJpKata.isEmpty())) {
            return olnEn != null && !olnEn.isEmpty();
        }
        return true;
    }

 // 旧姓フィールドのいずれかが入力された場合は、それ以外の旧姓フィールドも必須
    @AssertTrue(message = "ミドルネームの各欄に一つでも入力があった場合は必須です。	")
    public boolean isMiddleNameJpValid() {
        if ((mnJpHira != null && !mnJpHira.isEmpty()) ||
                (mnJpKata != null && !mnJpKata.isEmpty()) ||
                (mnEn != null && !mnEn.isEmpty())) {
            return mnJp != null && !mnJp.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = "ミドルネームの各欄に一つでも入力があった場合は必須です。	")
    public boolean isMiddleNameJpHiraValid() {
        if ((mnJp != null && !mnJp.isEmpty()) ||
                (mnJpKata != null && !mnJpKata.isEmpty()) ||
                (mnEn != null && !mnEn.isEmpty())) {
            return mnJpHira != null && !mnJpHira.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = "ミドルネームの各欄に一つでも入力があった場合は必須です。	")
    public boolean isMiddleNameJpKataValid() {
        if ((mnJp != null && !mnJp.isEmpty()) ||
                (mnJpHira != null && !mnJpHira.isEmpty()) ||
                (mnEn != null && !mnEn.isEmpty())) {
            return mnJpKata != null && !mnJpKata.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = "ミドルネームの各欄に一つでも入力があった場合は必須です。	")
    public boolean isMiddleNameEnValid() {
        if ((mnJp != null && !mnJp.isEmpty()) ||
                (mnJpHira != null && !mnJpHira.isEmpty()) ||
                (mnJpKata != null && !mnJpKata.isEmpty())) {
            return mnEn != null && !mnEn.isEmpty();
        }
        return true;
    }
}