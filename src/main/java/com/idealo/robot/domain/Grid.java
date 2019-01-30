package com.idealo.robot.domain;

import com.idealo.robot.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Grid {

    int x = 0;
    int y = 0;

    public Grid() {
    }

    private static int maxXLimit = 5;
    private static int maxYLimit = 5;


    public Grid(int x, int y) throws BusinessException {
        if (!isValidXandY(x, y)) {
            throw new BusinessException("Grid out of limits");
        }
        this.x = x;
        this.y = y;
    }

    private boolean isXValid(int x) {
        return x <= maxXLimit && x >= 0;
    }

    private boolean isYValid(int y) {
        return y <= maxYLimit && y >= 0;
    }

    private boolean isValidXandY(int x, int y) {
        return isXValid(x) && isYValid(y);
    }

}
