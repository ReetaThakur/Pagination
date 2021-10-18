package com.example.pagination.ui

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class CharacterRepository {
  fun getPageList()=Pager(config = PagingConfig(pageSize = 20),
      pagingSourceFactory = {CharcterPagingSource()}).liveData
}