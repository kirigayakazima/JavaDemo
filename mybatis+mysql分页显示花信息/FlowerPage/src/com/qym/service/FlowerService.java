package com.qym.service;

import java.io.IOException;


import com.qym.pojo.PageInfo;

public interface FlowerService {
	PageInfo showAll(int pageSize,int pageNumber) throws IOException;
}
