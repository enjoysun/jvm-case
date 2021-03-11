package com.myou.jvm;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.myou.jvm.listeners.FamilyDataListener;
import com.myou.jvm.listeners.HousingDataListener;
import com.myou.jvm.listeners.ProtocolDataListener;
import com.myou.jvm.models.ExpropriationCompensationModel;
import com.myou.jvm.models.FamilyData;
import com.myou.jvm.models.HousinginformationData;
import com.myou.jvm.models.ProtocolData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class JvmTestApplicationTests {

    private final int _1MB = 1024 * 1024;

    @Test
    void contextLoads() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[4 * _1MB];

    }

    @Test
    void easyexcelLoads() throws FileNotFoundException {
        String fileName = "/Users/myou/Downloads/征收补偿协议模板（房源交付表）_案例.xls";
        FileInputStream inputStream = new FileInputStream(fileName);
        FamilyData familyData = new FamilyData();
        ExcelReader excelReader = null;
        ExpropriationCompensationModel expropriationCompensationModel = new ExpropriationCompensationModel();
        try {
            excelReader = EasyExcel.read(inputStream).build();
            ReadSheet readSheetProtocol = EasyExcel.readSheet("协议信息").headRowNumber(3).head(ProtocolData.class).registerReadListener(new ProtocolDataListener(expropriationCompensationModel)).build();
            ReadSheet readSheetFamily = EasyExcel.readSheet("家庭信息").headRowNumber(3).head(FamilyData.class).registerReadListener(new FamilyDataListener(expropriationCompensationModel)).build();
            ReadSheet readSheetHouseInfo = EasyExcel.readSheet("房源信息").headRowNumber(3).head(HousinginformationData.class).registerReadListener(new HousingDataListener(expropriationCompensationModel)).build();
//            ReadSheet readSheet = EasyExcel.readSheet(3).head(FamilyData.class).registerReadListener(new FamilyDataListener(familyData)).build();
            excelReader.read(readSheetProtocol, readSheetFamily, readSheetHouseInfo);
//            excelReader.read(readSheetFamily);
        } finally {
            if (excelReader == null)
                excelReader.finish();
        }
    }

}
