#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 生效状态
 */
@Getter
public enum EffectiveStatusEnum {

    EFFECT(10,"生效"),

    DEACTIVATED(90,"失效")
    ;

    private final Integer code;

    private final String name;

    EffectiveStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map<Integer, String> CODE_TO_NAME =
            Arrays.stream(values())
                    .collect(Collectors.toMap(
                            EffectiveStatusEnum::getCode,
                            EffectiveStatusEnum::getName
                    ));

    public static String getNameByCode(Integer code) {
        return CODE_TO_NAME.getOrDefault(code, "未知生效状态");
    }
}
