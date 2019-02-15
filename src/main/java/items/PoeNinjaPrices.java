package items;

import java.util.ArrayList;
import java.util.List;

import connector.CurrencyPoeTradeFetcher;
import connector.PoeNinjaPriceFetcher;
import handler.CurrencyPoeTradeHandler;
import handler.PoeNinjaPriceCheckHandler;

public class PoeNinjaPrices {
	
	private List<PoeNinjaPriceItem> priceItemList;
	
	public PoeNinjaPrices() {
		priceItemList = new ArrayList<>();
	}

	public List<PoeNinjaPriceItem> getPriceItemList() {
		return priceItemList;
	}

	public void getPrices() {
		PoeNinjaPriceFetcher fetcher = new PoeNinjaPriceFetcher();
		String pricesAsJsonText = "";
		try {
			pricesAsJsonText = fetcher.sendGet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PoeNinjaPriceCheckHandler handler = new PoeNinjaPriceCheckHandler(pricesAsJsonText);
		priceItemList = handler.getPriceItemList();
	}
}
