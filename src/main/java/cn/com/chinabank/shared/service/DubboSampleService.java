package cn.com.chinabank.shared.service;

import cn.com.chinabank.shared.dto.BookDto;

import java.io.Serializable;

public interface DubboSampleService {

	Serializable execute(String s);

    Object execute(BookDto book);
}
