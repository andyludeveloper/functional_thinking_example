package com.andyludeveloper.functional_thinking.ch1

import java.util.regex.Pattern

class KWords {
    val NON_WORDS = setOf(
        "the",
        "and",
        "of",
        "to",
        "a",
        "i",
        "it",
        "in",
        "or",
        "is",
        "d",
        "s",
        "as",
        "so",
        "but",
        "be"
    )

    private fun regexToList(words: String, regex: String): List<String>{
        val wordList = mutableListOf<String>()
        val m = Pattern.compile(regex).matcher(words)
        while(m.find()) wordList.add(m.group())
        return wordList
    }

    fun wordFreq (words: String): Map<String, Int>{
        val wordMap = mutableMapOf<String, Int>()
        regexToList(words, "\\w+").stream()
            .map { w -> w.toLowerCase() }
            .filter { w -> !NON_WORDS.contains(w) }
            .forEach { w -> wordMap[w] = wordMap.getOrDefault(w, 0)+1 }
        return wordMap
    }

}