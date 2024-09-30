package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Transaksi;

public interface TransaksiService {
	Transaksi addTransaksi(Transaksi trx);
	List<Transaksi> getAll();
}
