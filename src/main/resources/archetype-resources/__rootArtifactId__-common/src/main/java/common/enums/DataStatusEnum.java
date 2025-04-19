#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum DataStatusEnum {
    Normal(10, "正常"),
    Delete(20, "删除");

    private final Integer code;
    private final String name;

    DataStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map<Integer, String> CODE_TO_NAME =
            Arrays.stream(values())
                    .collect(Collectors.toMap(
                            DataStatusEnum::getCode,
                            DataStatusEnum::getName
                    ));

    public static String getNameByCode(Integer code) {
        return CODE_TO_NAME.getOrDefault(code, "未知状态");
    }

}
