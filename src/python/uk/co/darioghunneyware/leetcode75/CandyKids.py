from typing import List

def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
    max_candies = max(candies)
    candies_list = []

    for candy in candies:
        if candy + extraCandies >= max_candies:
            candies_list.append(True)
        else:
            candies_list.append(False)

    return candies_list