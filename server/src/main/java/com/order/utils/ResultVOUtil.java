package com.order.utils;

import com.order.VO.ResultVO;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 16:41
 * @Description:
 */
public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
