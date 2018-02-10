import java.util.List;

public class LC_638 {

	public static void main(String[] args) {

	}

	public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < special.size(); i++) {
			List<Integer> offer = special.get(i);
			boolean validOffer = true;
			for (int j = 0; j < offer.size()-1; j++) {
				int remain = needs.get(j) - offer.get(j);
				if(remain < 0)
					validOffer = false;
				needs.set(j, remain);
			}
			if(validOffer)
				result = Math.min(result, shoppingOffers(price, special, needs) + offer.get(needs.size()));
			
			for (int j = 0; j < needs.size(); j++) {
				needs.set(j, needs.get(j)+offer.get(j));
			}
		}
		int nonOfferPrice = 0;
		for (int i = 0; i < needs.size(); i++) {
			nonOfferPrice += needs.get(i)*price.get(i);
		}
		return Math.min(result, nonOfferPrice);
	}
}
