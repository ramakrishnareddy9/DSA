Key Limitations (sieve) is 10⁷:
    1️. Memory Pressure
        Raw Cost
        boolean[] → ~1 byte per element
        →  ≈ 10 MB
        BitSet → ~1 bit per element
        → 10⁷ ≈ 1.25 MB
        Scaling Impact
        10⁸ → ~100 MB (boolean[])
        10⁹ → ~1 GB
        Memory becomes a bottleneck fast, especially in:
            Online judges
            Microservices with memory caps

    2️.Time Complexity Ceiling
        Sieve complexity:
            O(n log log n)
            Reality Check:
            10⁷ → fast (< 1 sec)
            10⁸ → borderline (2–5 sec)
            10⁹ → impractical
        Because you’re still iterating over millions of numbers + marking multiples