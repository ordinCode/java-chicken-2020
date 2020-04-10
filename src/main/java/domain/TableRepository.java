package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final String ERROR_MESSAGE_TABLE_NUMBER = "없는 테이블입니다";

    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table findByTableNumber(final int tableNumber) {
        return tables.stream()
                .filter(table -> table.isMatchNumber(tableNumber))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ERROR_MESSAGE_TABLE_NUMBER);
                });
    }
}
