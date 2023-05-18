/**
Utility to connect to Celo Web3 Blockchain network and perform CRUD operations
@author Balaji
*/
package com.sandbox.util;

import java.math.BigDecimal;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Ethereum;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.FastRawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

public class BlockchainCeloUtilities {
	
	static String celoURL = "https://alfajores-forno.celo-testnet.org";
	
	public static String[] createCeloAccount(String passwd) throws Exception
	{		
		Web3j web3 = Web3j.build(new HttpService(celoURL));
		//System.out.println("Successfuly connected to blockchain network");		
		//String PRIVATE_KEY="0x99569f5066671216a6e6d6014bccf9d6ee5c9f765c3994da153ee46f1cb712cd";
		EthAccounts acct = new EthAccounts();
		String password = passwd;
		ECKeyPair keyPair = Keys.createEcKeyPair();
		WalletFile wallet = Wallet.createStandard(password, keyPair);
		String str[] =new String[2];
		str[0] = keyPair.getPrivateKey().toString(16);
		str[1] = "0x" + wallet.getAddress();
		//System.out.println("Private key" + keyPair.getPrivateKey().toString(16));
		//System.out.println("Account: 0x"+wallet.getAddress());
		return str;
	}
	
	public static String sendFunds(String receiverWalletAddress, String chargeableWalletPasscode, double commissionAmt) throws Exception
	{
		Web3j web3 = Web3j.build(new HttpService("https://alfajores-forno.celo-testnet.org"));
		Credentials credentials = Credentials.create(chargeableWalletPasscode);;
		TransactionReceipt transactionReceipt =
		 Transfer.sendFunds(
		 web3,
		 credentials, receiverWalletAddress,
		 BigDecimal.valueOf(commissionAmt),
		 Convert.Unit.ETHER).send();
		return "Funds transfer completed. Transaction receipt ->"+transactionReceipt; 
		
	}	
	

}
