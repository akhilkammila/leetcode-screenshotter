"""
Looks into stats on leetcode premium problems
vs non premium problems
"""

import pandas as pd
import matplotlib.pyplot as plt

def difficultyVsAcceptance():
    df = pd.read_csv("data/problem_data.csv")
    df = df.dropna()
    df = df[df['Premium'] == True]
    df = df[df['Acceptance'] != 'N/A']
    df = df[df['Difficulty'] != 'N/A']
    df['Acceptance'] = df['Acceptance'].str.rstrip('%').astype('float') / 100.0
    df['Difficulty'] = df['Difficulty'].map({'Easy': 1, 'Medium': 2, 'Hard': 3})
    df = df.sort_values(by=['Difficulty'])
    print(df)
    df.plot.scatter(x='Difficulty', y='Acceptance')
    plt.show()

"""
Prints the number of premium problems vs total problems
"""
def numberOfPremium():
    df = pd.read_csv("data/problem_data.csv")
    df = df.dropna()

    total_problems = len(df)
    premiums = df[df['Premium'] == True]
    premium_problems = len(premiums)

    print ("------ PREMIUM DATA ------")
    print("number of premium problems: {}".format(premium_problems))
    print("number of total problems: {}".format(total_problems))
    print("percentage of premium problems: {}".format(premium_problems/total_problems))
    
    print("number of premium problems by difficulty:")
    print(df['Difficulty'].value_counts())
    print("number of total problems by difficulty")
    print(premiums['Difficulty'].value_counts())

"""
Plots the difficulty distribution of all problems, premium problems, and non-premium problems
"""
def difficultyDistribution():
    # Plot all problems
    df = pd.read_csv("data/problem_data.csv")
    df = df.dropna()
    df['Difficulty'] = df['Difficulty'].map({'Easy': 1, 'Medium': 2, 'Hard': 3})

    premiumProbs = df[df['Premium'] == True]
    nonPremiumProbs = df[df['Premium'] == False]
    allProbs = df

    # Plot a graph with three columns, one for each difficulty
    fig, axs = plt.subplots(1, 3, sharey=True, tight_layout=True)
    axs[0].hist(allProbs['Difficulty'])
    axs[0].set_title('All Problems')
    axs[1].hist(premiumProbs['Difficulty'])
    axs[1].set_title('Premium Problems')
    axs[2].hist(nonPremiumProbs['Difficulty'])
    axs[2].set_title('Non-Premium Problems')
    plt.show()


if __name__ == "__main__":
    numberOfPremium()
    # difficultyDistribution()