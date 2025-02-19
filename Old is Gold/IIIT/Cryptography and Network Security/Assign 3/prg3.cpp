#include <iostream>
#include <gmpxx.h>
#include <unordered_map>


std::unordered_map<char, int> charToVal = {
        {'0', 0}, {'1', 1}, {'2', 2}, {'3', 3}, {'4', 4}, {'5', 5}, {'6', 6}, {'7', 7}, {'8', 8}, {'9', 9},
        {' ', 10}, {'a', 11}, {'b', 12}, {'c', 13}, {'d', 14}, {'e', 15}, {'f', 16}, {'g', 17}, {'h', 18},
        {'i', 19}, {'j', 20}, {'k', 21}, {'l', 22}, {'m', 23}, {'n', 24}, {'o', 25}, {'p', 26}, {'q', 27},
        {'r', 28}, {'s', 29}, {'t', 30}, {'u', 31}, {'v', 32}, {'w', 33}, {'x', 34}, {'y', 35}, {'z', 36}
    };

void generateRandomPrime(mpz_t prime, unsigned int bits) {
    gmp_randstate_t state;
    gmp_randinit_default(state);
    mpz_urandomb(prime, state, bits);
    mpz_nextprime(prime, prime);
    gmp_randclear(state);
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        std::cerr << "Usage: " << argv[0] << " <plaintext>\n";
        return 1;
    }

    mpz_class p, q, n, phi_n, e, d, s;

    // Generate 512-bit primes p and q
    generateRandomPrime(p.get_mpz_t(), 256);
    generateRandomPrime(q.get_mpz_t(), 256);

    n = p * q;
    phi_n = (p - 1) * (q - 1);

    e = 65537;

    mpz_invert(d.get_mpz_t(), e.get_mpz_t(), phi_n.get_mpz_t());

    std::string plaintext = argv[1];
    mpz_class plaintextValue = 0;
    for (char c : plaintext) {
        plaintextValue = plaintextValue * 37 + charToVal[c];
    }

    mpz_powm(s.get_mpz_t(), plaintextValue.get_mpz_t(), d.get_mpz_t(), n.get_mpz_t());
    std::cout << "Signature: " << s << std::endl;

    return 0;
}
