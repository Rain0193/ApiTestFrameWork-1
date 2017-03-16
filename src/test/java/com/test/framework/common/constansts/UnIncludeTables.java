package com.test.framework.common.constansts;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hong.lin
 * @description
 * @date 2017/2/28.
 */
public class UnIncludeTables {
    private static List<String> unIncldeTable = new ArrayList<String>();
    static {
        unIncldeTable.add("cr_province");
        unIncldeTable.add("cr_city");
        unIncldeTable.add("cr_area");
        unIncldeTable.add("cr_street");
    }

    public static List<String> getUnIncludeTables(){
        return unIncldeTable;
    }
}
