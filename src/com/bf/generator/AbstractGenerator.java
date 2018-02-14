package com.bf.generator;

import java.util.List;

public abstract class AbstractGenerator
{
	abstract public List<Integer> generateNumbers(int maxNums, int picks) throws Exception;
}
