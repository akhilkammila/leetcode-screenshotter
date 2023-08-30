class Solution(object):
    def areSentencesSimilar(self, sentence1, sentence2, similarPairs):
        if len(sentence1) != len(sentence2):
            return False
        wordToSimilarWords = defaultdict(set)
        for word1, word2 in similarPairs:
            wordToSimilarWords[word1].add(word2)
            wordToSimilarWords[word2].add(word1)
        for i in range(len(sentence1)):
            if sentence1[i] == sentence2[i] or sentence2[i] in wordToSimilarWords[sentence1[i]]:
                continue
            return False
        return True