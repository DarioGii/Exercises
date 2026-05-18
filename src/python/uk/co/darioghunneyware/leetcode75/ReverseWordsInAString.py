import re

def reverse_words(self, s: str) -> str:
    words = re.split(r'\s+', s.strip())

    if len(words) == 1:
        return words[0]
    else:
        words.reverse()
        return ' '.join(words)