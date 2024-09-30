package com.lawencon.minimarket.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Transaksi;
import com.lawencon.minimarket.service.TransaksiService;

public class TransaksiServiceImpl implements TransaksiService {
	private List<Transaksi> transaksiList = new ArrayList<>();
	@Override
	public Transaksi addTransaksi(Transaksi trx) {
		transaksiList.add(trx);
		return trx;
	}

	@Override
	public List<Transaksi> getAll() {
		if(transaksiList.size() == 0) {
			System.out.println("Belum Ada Transaksi");
		}
		return transaksiList;
	}

}
