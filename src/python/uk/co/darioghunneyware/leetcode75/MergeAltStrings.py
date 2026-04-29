def merge_alternately(word1, word2):
    use_other_word = False
    merged_word = ""
    counter1, counter2 = 0, 0
    word_length = len(word1) + len(word2)

    while len(merged_word) < word_length:
        while counter1 < len(word1) and counter2 < len(word2):
            if not use_other_word:
                merged_word += word1[counter1]
                counter1 += 1
                use_other_word = True
            else:
                merged_word += word2[counter2]
                counter2 += 1
                use_other_word = False

        if counter1 >= len(word1) and counter2 < len(word2):
            merged_word += word2[counter2:]
        else:
            merged_word += word1[counter1:]

    return merged_word