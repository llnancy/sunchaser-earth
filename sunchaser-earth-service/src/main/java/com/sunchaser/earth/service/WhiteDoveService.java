package com.sunchaser.earth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunchaser.earth.common.enums.TableStatusEnum;
import com.sunchaser.earth.common.enums.WhiteDoveTypeEnum;
import com.sunchaser.earth.common.enums.file.FileTypeEnum;
import com.sunchaser.earth.common.util.Constants;
import com.sunchaser.earth.dao.entity.WhiteDove;
import com.sunchaser.earth.dao.mapper.WhiteDoveMapper;
import com.sunchaser.earth.domain.request.SelectWhiteDoveRequest;
import com.sunchaser.earth.domain.response.dto.WhiteDoveDTO;
import com.sunchaser.earth.domain.response.vo.WhiteDoveVO;
import com.sunchaser.earth.integrate.upload.UploadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/19
 */
@Service
@Slf4j
public class WhiteDoveService {

    @Autowired
    private UploadFactory uploadFactory;

    @Resource
    private WhiteDoveMapper whiteDoveMapper;

    public String saveWhiteDove(MultipartFile file) throws Exception {
        String upload = uploadFactory.getUploader(FileTypeEnum.IMAGE).upload(file);
        WhiteDove whiteDove = new WhiteDove();
        whiteDove.setCreateTime(new Date());
        whiteDove.setUpdateTime(new Date());
        whiteDove.setSource(upload);
        whiteDove.setStatus(TableStatusEnum.NORMAL.getStatus());
        whiteDove.setType(WhiteDoveTypeEnum.IMAGE.getType());
        int insert = whiteDoveMapper.insert(whiteDove);
        return insert == 1 ? upload : Constants.StringConstants.EMPTY;
    }

    public WhiteDoveVO pageSelectList(SelectWhiteDoveRequest selectWhiteDoveRequest) {
        Page<WhiteDove> whiteDovePage = whiteDoveMapper.selectPage(
                Page.of(selectWhiteDoveRequest.getPageNo(), selectWhiteDoveRequest.getPageSize()),
                new QueryWrapper<WhiteDove>().lambda()
                        .eq(WhiteDove::getType, WhiteDoveTypeEnum.IMAGE.getType())
                        .orderByDesc(WhiteDove::getCreateTime)
        );
        List<WhiteDove> records = whiteDovePage.getRecords();
        long total = whiteDovePage.getTotal();
        boolean hasNext = whiteDovePage.hasNext();
        WhiteDoveVO whiteDoveVO = new WhiteDoveVO();
        if (CollectionUtils.isEmpty(records)) {
            return whiteDoveVO;
        }
        List<WhiteDoveDTO> whiteDoveVOList = records.stream()
                .map(WhiteDove::doConvert)
                .collect(Collectors.toList());
        whiteDoveVO.setRecords(whiteDoveVOList);
        whiteDoveVO.setCount(total);
        whiteDoveVO.setHasNext(hasNext);
        return whiteDoveVO;
    }
}
