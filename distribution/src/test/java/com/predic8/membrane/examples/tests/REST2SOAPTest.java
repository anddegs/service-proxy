/* Copyright 2012 predic8 GmbH, www.predic8.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License. */

package com.predic8.membrane.examples.tests;

import static com.predic8.membrane.test.AssertUtils.assertContains;
import static com.predic8.membrane.test.AssertUtils.getAndAssert200;

import com.predic8.membrane.examples.util.*;
import org.junit.jupiter.api.Test;

public class REST2SOAPTest extends DistributionExtractingTestcase {

	@Override
	protected String getExampleDirName() {
		return "rest2soap";
	}

	@Test
	public void test() throws Exception {
		try(Process2 ignored = startServiceProxyScript()) {
			assertContains("<ns1:bic>COLSDE33XXX</ns1:bic>", getAndAssert200("http://localhost:2000/bank/37050198"));
			assertContains("<ns1:bic>GENODE61KIR</ns1:bic>", getAndAssert200("http://localhost:2000/bank/66762332"));
		}
	}
}
