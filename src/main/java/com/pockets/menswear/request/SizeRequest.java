package com.pockets.menswear.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SizeRequest {
    private long id;

    private int small;

    private int medium;

    private int large;

    private int xlarge;

    private int xxlarge;
}
