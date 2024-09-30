package com.lawencon.asongan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.asongan.model.Transaksi;
import com.lawencon.asongan.service.TransaksiService;

public class TransaksiImpl implements TransaksiService {
	private List<Transaksi> transaksilist = new ArrayList<>();
	
	@Override
	public Transaksi addTransaksi(Transaksi transaksi) {
		transaksilist.add(transaksi);
		return transaksi;
	}

	@Override
	public List<Transaksi> getAll() {
		// TODO Auto-generated method stub
		return transaksilist;
	}

}
